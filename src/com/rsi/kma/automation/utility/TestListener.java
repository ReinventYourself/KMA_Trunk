package com.rsi.kma.automation.utility;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;
import org.testng.IAnnotationTransformer;
import org.testng.IExecutionListener;
import org.testng.IInvokedMethod;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.ITestAnnotation;
import org.testng.collections.Lists;
import org.testng.xml.XmlSuite;

import com.rsi.kma.automation.modules.EmailModule;






public class TestListener implements IExecutionListener, ISuiteListener,ITestListener,IRetryAnalyzer ,IReporter  , IAnnotationTransformer {

	private static Logger           Log           = Logger.getLogger(TestListener.class.getName());
	static long                     folderCount   = 0;
	static long                     fileCount       = 0;
	private  int       count         = 0;
	
	static ArrayList<String> platform=new ArrayList<String>();
	static String lastTestName="";
	

	private PrintWriter out;
	private int row;
	private Integer testIndex;
	private int methodIndex;
	private Scanner scanner;
	
	public static Date date=null;
	
	public static String destination =null;
	public static int m_row;
	public static String platformName=null;
	public static PrintWriter writer;
	public static PrintWriter getWriter() {
		return writer;
	}

	public static void setWriter(PrintWriter writer) {
		TestListener.writer = writer;
	}
	public static String getDestination() {
		return destination;
	}

	public static void setDestination(String destination) {
		TestListener.destination = destination;
	}


	public static String outdir=Constants.reportDirectory;

	@Override
	public void onExecutionStart() {
		/**
		 * Setting-up log4j file location
		 */
		try{
			System.setProperty(
					"logfilename",
					"Log");}

		catch (Exception e){
			Log.error(e.getMessage());
			System.exit(0);
		}

		try{
			String tempFileName = System.getProperties().getProperty("java.io.tmpdir");
			File tempDir = new File(tempFileName);

			TestListener.recursiveDeleteFilesAndFolders(tempDir);
			Log.info("temp files deleted.");

		} catch (Exception e){
			Log.error("temp files can't be cleaned. Pls try manually.");
		}

	}

	@Override
	public void onExecutionFinish() {
		try {
			EmailModule.execute("customized-report.html");
		} catch (Exception e) {
			Log.info("Please check email configuration");
			e.printStackTrace();
		}
	}



	@Override
	public void onStart(ISuite suite) {
		Log.info("");
		Log.info(" ***** SUITE NAME: " + suite.getName() + " ***** ");
		Constants.browser = suite.getParameter("browser").toUpperCase();
		Log.info("Browser: " + Constants.browser);
	}



	@Override
	public void onTestStart(ITestResult result) {
		Log.info("");
		String testName=result.getMethod().getMethodName();
		Utils.h.put(testName, Utils.getPlatform());
		
		Log.info(" ***** " + result.getMethod().getMethodName() + " (" + result.getTestClass().getName() + ") STARTS" + " ***** ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String [] split = result.getTestClass().getName().split("regression\\.");
		String module_TestName [] = split[split.length-1].split("\\.");
		String testClass = module_TestName[module_TestName.length-1];
		Log.info(" PASS " + result.getMethod().getDescription() + " " + result.getMethod().getMethodName() + " " +  testClass+ " "  + Constants.browser);   


		/** 
		 * If between any run from 0 to MAX_RETRY_COUNT, TC got PASS; count is not getting re-set to 0.
		 * TestListener.retry gets called only if TC got FAIL. 
		 * Therefore here we are explicitly re-setting count to 0 after every PASS. 
		 */
		count = 0;

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String [] split = result.getTestClass().getName().split("regression\\.");
		String module_TestName [] = split[split.length-1].split("\\.");
		String testClass = module_TestName[module_TestName.length-1];
		Utils.takeScreenshot(BaseClass.driver, result);
		Log.info(" FAIL " + result.getMethod().getDescription() + " " + result.getMethod().getMethodName() + " " +  testClass+ " " + Constants.browser);
		 
		
		  
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String [] split = result.getTestClass().getName().split("regression\\.");
		String module_TestName [] = split[split.length-1].split("\\.");
		String testClass = module_TestName[module_TestName.length-1];

		try {
			Thread.sleep(3);   //deliberate sleep of 3 millis inserted to avoid same time skip result publication.......
		} catch (InterruptedException e) {
			Log.info("Delibrate sleep of 3 millis in case of skips interrupted.");
		}

		Utils.takeScreenshot(BaseClass.driver, result);
		Log.info(" SKIP " + result.getMethod().getDescription() + " " + result.getMethod().getMethodName() + " " +  testClass+ " " + Constants.browser);


	count = 0;
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		//Log.info("********** " + context.getName() + " STARTS **********");
	}

	@Override
	public void onFinish(ITestContext testContext) { 
	
		 Iterator<ITestResult> skipTestCases = testContext.getSkippedTests().getAllResults().iterator();
		    while (skipTestCases.hasNext())
		    {
		        ITestResult skippedTestCase = skipTestCases.next();
		        ITestNGMethod method = skippedTestCase.getMethod();            
		        if ( testContext.getSkippedTests().getResults(method).size() > 1)
		        {
		            Log.info("failed test case remove as dup:" + skippedTestCase.getTestClass().toString());
		            skipTestCases.remove();                  
		        }
		        else
		        {
		            
		            if (testContext.getPassedTests().getResults(method).size() > 0)
		            {
		                Log.info("failed test case remove as pass retry:" + skippedTestCase.getTestClass().toString());
		                skipTestCases.remove();
		            } 
		            if (testContext.getFailedTests().getResults(method).size() > 0)
		            {
		                Log.info("skip test case remove as skip retry:" + skippedTestCase.getTestClass().toString());
		                skipTestCases.remove();
		            }
		        }            
		    }
		  Hashtable<String,String>h=Utils.h;
		    
		    for(Entry<String, String> m:h.entrySet()){
				
				System.out.println("Hash is: "+m.getValue()+" "+m.getKey());
			}
	
	} 
	
    // remove the test that passed on retry
   
	/*Delete all temp files before execution gets started*/
	public static void recursiveDeleteFilesAndFolders(File file)
	{
		/**
		 * to end the recursive loop
		 */
		if (!file.exists())
			return;

		/**
		 * if directory, go inside and call recursively
		 */
		if (file.isDirectory())
		{
			for (File f : file.listFiles())
			{
				//call recursively
				recursiveDeleteFilesAndFolders(f);
			}
		}

		/** call delete to delete files and empty directory */
		boolean isDeleted = file.delete();

		/** check deletion successful */
		if(isDeleted)
		{
			if(file.isDirectory())
			{
				folderCount++;

			}
			else
			{
				fileCount++;

			}
		}
		else
		{
			Log.info("Temp files are already deleted");
		}
	}


	

	@Override
	public boolean retry(ITestResult result) {

		 
		int MAX_RETRY_COUNT=BaseClass.getRetryCount();
		if(count < MAX_RETRY_COUNT) {                     
            count++;    

            String [] split = result.getTestClass().getName().split("regression\\.");
            String module_TestName [] = split[split.length-1].split("\\.");
            String testClass = module_TestName[module_TestName.length-1]; 
            String platform = module_TestName[module_TestName.length-2];
            Log.info("");
            Log.info(" ***** RE-RUN " + result.getMethod().getDescription() + " " + result.getMethod().getMethodName()
                    + " " + testClass + " " + platform + count); 
            
            
          
            
            return true; 
        }       
        count = 0;    
    return false; 



	}


	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		if (annotation.getRetryAnalyzer() == null) {
            annotation.setRetryAnalyzer(TestListener.class);
        } 

	}




	
	
	
	/*****************************************************************************************************************************
	 ******************************************************************************************************************************
	 *****************************************Customized Report code***************************************************************/





	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outdir) {
		try {
			out = createWriter(outdir);
		} catch (IOException e) {
			Log.error("output file", e);
			return;
		}

		startHtml(out);
		generateSuiteSummaryReport(suites);
		generateMethodSummaryReport(suites);
		generateMethodDetailReport(suites);
		endHtml(out);
		out.flush();
		out.close();
	}

	protected PrintWriter createWriter(String outdir) throws IOException {

		new File(outdir).mkdirs();
		File eReport=new File(outdir, "customized-report.html" );
		System.out.println(eReport.toPath());
		System.out.println("eReport.exists()  "+eReport.exists());
		if(eReport.exists()){
			eReport.delete();
			System.out.println("Deleted");
		}
		return new PrintWriter(new BufferedWriter(new FileWriter(new File(outdir, "customized-report.html"))));

	}

	/**
	 * Creates a table showing the highlights of each test method with links to
	 * the method details
	 */
	protected void generateMethodSummaryReport(List<ISuite> suites) {
		methodIndex = 0;
		startResultSummaryTable("methodOverview");
		int testIndex = 1;
		
		for (ISuite suite : suites) {
			if (suites.size() >= 1) {
				titleRow(suite.getName(), 5);
			}
			
			
			
			Map<String, ISuiteResult> r = suite.getResults();
			for (ISuiteResult r2 : r.values()) {
				ITestContext testContext = r2.getTestContext();
				String testName = testContext.getName();
				
				
				this.testIndex = testIndex;
				resultSummary(suite, testContext.getFailedConfigurations(),
						testName, "failed", " (configuration methods)");
				resultSummary(suite, testContext.getFailedTests(), testName,
						"failed", "");
				resultSummary(suite, testContext.getSkippedConfigurations(),
						testName, "skipped", " (configuration methods)");
				resultSummary(suite, testContext.getSkippedTests(), testName,
						"skipped", "");
				resultSummary(suite, testContext.getPassedTests(), testName,
						"passed", "");
				testIndex++;
				
			}
		}
		out.println("</table>");
	}

	/** Creates a section showing known results for each method */
	protected void generateMethodDetailReport(List<ISuite> suites) {
		methodIndex = 0;
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> r = suite.getResults();
			for (ISuiteResult r2 : r.values()) {
				ITestContext testContext = r2.getTestContext();
				if (r.values().size() > 0) {
					out.println("<h1>" + testContext.getName() + "</h1>");
				}
				resultDetail(testContext.getFailedConfigurations());
				resultDetail(testContext.getFailedTests());
				resultDetail(testContext.getSkippedConfigurations());
				resultDetail(testContext.getSkippedTests());
				resultDetail(testContext.getPassedTests());
			}
		}
	}

	/**
	 * @param tests
	 */
	private void resultSummary(ISuite suite, IResultMap tests, String testname,
			String style, String details) {
		if (tests.getAllResults().size() > 0) {
			StringBuffer buff = new StringBuffer();
			String lastClassName = "";
			int mq = 0;
			int cq = 0;
			for (ITestNGMethod method : getMethodSet(tests, suite)) {
				
				
				row += 1;
				methodIndex += 1;
				ITestClass testClass = method.getTestClass();
				String className = testClass.getName();
				if (mq == 0) {
					String id = (testIndex == null ? null : "t"
							+ Integer.toString(testIndex));
					titleRow(testname + " &#8212; " + style + details, 5, id);
					testIndex = null;
				}
				if (!className.equalsIgnoreCase(lastClassName)) {
					if (mq > 0) {
						cq += 1;
						out.print("<tr class=\"" + style
								+ (cq % 2 == 0 ? "even" : "odd") + "\">"
								+ "<td");
						if (mq > 1) {
							out.print(" rowspan=\"" + mq + "\"");
						}
						out.println(">" + lastClassName + "</td>" + buff);
						
						
					}
					mq = 0;
					buff.setLength(0);
					lastClassName = className;
				}
				Set<ITestResult> resultSet = tests.getResults(method);
				long end = Long.MIN_VALUE;
				long start = Long.MAX_VALUE;
				long startMS=0;
				int i=0;
				//String firstLine="";
				//String screenshotLnk="";
				for (ITestResult testResult : tests.getResults(method)) {
					
					if (testResult.getEndMillis() > end) {
						end = testResult.getEndMillis()/1000;
					}
					if (testResult.getStartMillis() < start) {
						startMS = testResult.getStartMillis();
						start =startMS/1000;
					}
					
					 
					Throwable exception=testResult.getThrowable();
					//String str = Utils.stackTrace(exception, true)[0];
					boolean hasThrowable = exception != null;
					if(hasThrowable){
						String str=exception.toString();
						//String str = Utils.stackTrace(exception, true)[0];
						//String str="";
						scanner = new Scanner(str);
						//firstLine = scanner.nextLine();

						//for link in exception
						List<String> msgs = Reporter.getOutput(testResult);
						boolean hasReporterOutput = msgs.size() > 0;
						if(hasReporterOutput){
							for (String line : msgs) {
								//out.println(line + "<br/>");
								//screenshotLnk+=line+"<br/>";
							}
						}

					}
				}

				DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(startMS);

				mq += 1;
				if (mq > 1) {
					buff.append("<tr class=\"" + style
							+ (cq % 2 == 0 ? "odd" : "even") + "\">");
				}
				//String description = method.getDescription();
				String testInstanceName = resultSet
						.toArray(new ITestResult[] {})[0].getTestName();
			String methodName=qualifiedName(method).replaceAll("\\<[^>]*>","");
				
				//string = string.replaceAll("<br[\\s/]*>", "");
                buff.append("<td><a href=\"#m"
                        + methodIndex
                        + "\">"
                        + qualifiedName(method)
                        + "</a>"
                        + (null == testInstanceName ? "" : "<br>("
                        + testInstanceName + ")") + "</td>"
                        +"<td style=\"text-align:right\">" + Utils.h.get(methodName) + "</td>"
                        + "<td style=\"text-align:right\">" + formatter.format(calendar.getTime()) + "</td>" + "<td class=\"numi\">"
                        + millisToTimeConversion(end - start) + "</td>" + "</tr>");
                //resultSet.size()
            }


			if (mq > 0) {
				cq += 1;
				out.print("<tr class=\"" + style
						+ (cq % 2 == 0 ? "even" : "odd") + "\">" + "<td");
				if (mq > 1) {
					out.print(" rowspan=\"" + mq + "\"");
				}
				out.println(">" + lastClassName + "</td>" + buff);
			}
		}
	}

	private String millisToTimeConversion(long seconds) {

		final int MINUTES_IN_AN_HOUR = 60;
		final int SECONDS_IN_A_MINUTE = 60;

		int minutes = (int) (seconds / SECONDS_IN_A_MINUTE);
		seconds -= minutes * SECONDS_IN_A_MINUTE;

		int hours = minutes / MINUTES_IN_AN_HOUR;
		minutes -= hours * MINUTES_IN_AN_HOUR;

		return prefixZeroToDigit(hours) + ":" + prefixZeroToDigit(minutes) + ":" + prefixZeroToDigit((int)seconds);
	}

	private String prefixZeroToDigit(int num){
		int number=num;
		if(number<=9){
			String sNumber="0"+number;
			return sNumber;
		}
		else
			return ""+number;

	}

	/** Starts and defines columns result summary table */
	private void startResultSummaryTable(String style) {
		tableStart(style, "summary");
		out.println("<tr><th>Class</th>"
				+ "<th>Method</th><th>Platform</th><th>Start Time </th><th>Time<br/>(hh:mm:ss)</th></tr>");
		row = 0;
	}

	private String qualifiedName(ITestNGMethod method) {
		StringBuilder addon = new StringBuilder();
		String[] groups = method.getGroups();
		int length = groups.length;
		if (length > 0 && !"basic".equalsIgnoreCase(groups[0])) {
			addon.append("(");
			for (int i = 0; i < length; i++) {
				if (i > 0) {
					addon.append(", ");
				}
				addon.append(groups[i]);
			}
			addon.append(")");
		}

		return "<b>" + method.getMethodName() + "</b> ";
	}

	private void resultDetail(IResultMap tests) {

		//Mahesh added
		Set<ITestResult> testResults=tests.getAllResults();
		//System.out.println("resultDetail before sort .."+ testResults);
		List<ITestResult> list = new ArrayList<ITestResult>(testResults);
		Collections.sort(list, new TestResultsSorter());
		//System.out.println("resultDetail after sort .."+ list);

		//for (ITestResult result : tests.getAllResults()) {
		for (ITestResult result : list) {
			ITestNGMethod method = result.getMethod();
			methodIndex++;
			String cname = method.getTestClass().getName();
			out.println("<h2 id=\"m" + methodIndex + "\">" + cname + ":"
					+ method.getMethodName() + "</h2>");
			Set<ITestResult> resultSet = tests.getResults(method);
			generateForResult(result, method, resultSet.size());
			out.println("<p class=\"totop\"><a href=\"#summary\">back to summary</a></p>");

		}
	}

	private void generateForResult(ITestResult ans, ITestNGMethod method,
			int resultSetSize) {
		Object[] parameters = ans.getParameters();
		boolean hasParameters = parameters != null && parameters.length > 0;
		if (hasParameters) {
			tableStart("result", null);
			out.print("<tr class=\"param\">");
			for (int x = 1; x <= parameters.length; x++) {
				out.print("<th>Param." + x + "</th>");
			}
			out.println("</tr>");
			out.print("<tr class=\"param stripe\">");
			for (Object p : parameters) {
				/* out.println("<td>" + Utils.escapeHtml(Utils.toString(p))
                            + "</td>");*/
			}
			out.println("</tr>");
		}
		List<String> msgs = Reporter.getOutput(ans);
		boolean hasReporterOutput = msgs.size() > 0;
		Throwable exception = ans.getThrowable();
		boolean hasThrowable = exception != null;
		if (hasReporterOutput || hasThrowable) {
			if (hasParameters) {
				out.print("<tr><td");
				if (parameters.length > 1) {
					out.print(" colspan=\"" + parameters.length + "\"");
				}
				out.println(">");
			} else {
				out.println("<div>");
			}
			if (hasReporterOutput) {
				if (hasThrowable) {
					out.println("<h3>Test Messages</h3>");
				}
				for (String line : msgs) {
					out.println(line + "<br/>");
				}
			}
			if (hasThrowable) {
				boolean wantsMinimalOutput = ans.getStatus() == ITestResult.SUCCESS;
				if (hasReporterOutput) {
					out.println("<h3>"
							+ (wantsMinimalOutput ? "Expected Exception"
									: "Failure") + "</h3>");
				}
				generateExceptionReport(exception, method);
			}
			if (hasParameters) {
				out.println("</td></tr>");
			} else {
				out.println("</div>");
			}
		}
		if (hasParameters) {
			out.println("</table>");
		}
	}

	protected void generateExceptionReport(Throwable exception,
			ITestNGMethod method) {
		out.print("<div class=\"stacktrace\">");
		//out.print(Utils.stackTrace(exception, true)[0]);
		out.println("</div>");
	}

	/**
	 * Since the methods will be sorted chronologically, we want to return the
	 * ITestNGMethod from the invoked methods.
	 */
	private Collection<ITestNGMethod> getMethodSet(IResultMap tests,
			ISuite suite) {
		List<IInvokedMethod> r = Lists.newArrayList();
		List<IInvokedMethod> invokedMethods = suite.getAllInvokedMethods();
		for (IInvokedMethod im : invokedMethods) {
			//System.out.println("suite.getAllInvokedMethods()  .."+im);
			if (tests.getAllMethods().contains(im.getTestMethod())) {
				r.add(im);
			}
		}
		//System.out.println("r ....."+ r.toString());
		//Arrays.sort(r.toArray(new IInvokedMethod[r.size()]), new TestSorter());
		Collections.sort(r,new TestSorter());

		//System.out.println("Sorted Array .."+r.toString());
		List<ITestNGMethod> result = Lists.newArrayList();

		// Add all the invoked methods
		for (IInvokedMethod m : r) {
			for(ITestNGMethod temp:result){
				if(!temp.equals(m.getTestMethod()))
					result.add(m.getTestMethod());
			}
		}

		// Add all the methods that weren't invoked (e.g. skipped) that we
		// haven't added yet

		Collection<ITestNGMethod> allMethodsCollection=tests.getAllMethods();
		List<ITestNGMethod> allMethods=new ArrayList<ITestNGMethod>(allMethodsCollection);
		//System.out.println("All methods before sort"+ allMethods.toString());
		Collections.sort(allMethods, new TestMethodSorter());
		//System.out.println("After sorting "+allMethods.toString());

		//for (ITestNGMethod m : tests.getAllMethods()) {
		for (ITestNGMethod m : allMethods) {
			//System.out.println("tests.getAllMethods()  .."+m);
			if (!result.contains(m)) {
				result.add(m);
			}
		}
		//System.out.println("results ....."+ result.toString());
		return result;
	}

	@SuppressWarnings("unused")
	public void generateSuiteSummaryReport(List<ISuite> suites) {
		tableStart("testOverview", null);
		out.print("<tr>");
		tableColumnStart("Test");
		tableColumnStart("# passed");
		//tableColumnStart("Scenarios<br/>Passed");
		tableColumnStart("# skipped");
		tableColumnStart("# failed");
		tableColumnStart("Date");
		//tableColumnStart("Parameters");
		tableColumnStart("Start<br/>Time");
		tableColumnStart("End<br/>Time");
		tableColumnStart("Total<br/>Time(hh:mm:ss)");
		

		out.println("</tr>");
		NumberFormat formatter = new DecimalFormat("#,##0.0");
		int qty_tests = 0;
		int qty_pass_m = 0;
		int qty_pass_s = 0;
		int qty_skip = 0;
		int qty_fail = 0;
		long time_start = Long.MAX_VALUE;
		long time_end = Long.MIN_VALUE;
		testIndex = 1;
		for (ISuite suite : suites) {
			if (suites.size() >= 1) {
				titleRow(suite.getName(), 10);
			}
			Map<String, ISuiteResult> tests = suite.getResults();
			for (ISuiteResult r : tests.values()) {
				qty_tests += 1;
				ITestContext overview = r.getTestContext();
				startSummaryRow(overview.getName());
				int q = getMethodSet(overview.getPassedTests(), suite).size();
				qty_pass_m += q;
				summaryCell(q, Integer.MAX_VALUE);
				/*q = overview.getPassedTests().size();
                               qty_pass_s += q;
                               summaryCell(q, Integer.MAX_VALUE);*/
				q = getMethodSet(overview.getSkippedTests(), suite).size();
				qty_skip += q;
				summaryCell(q, 0);
				q = getMethodSet(overview.getFailedTests(), suite).size();
				qty_fail += q;
				summaryCell(q, 0);
				date= overview.getEndDate();
				
				String suiteMonth=date.toString().substring(4, 7);
				
				String suiteDate=date.toString().substring(8, 10);
				
				String year=date.toString().substring((date.toString().length()-4),date.toString().length());
				
				String Date=suiteDate+" "+suiteMonth+" "+year;
				Log.info("Date is ****"+Date);
				summarycell(Date,true);
			
				SimpleDateFormat summaryFormat = new SimpleDateFormat("hh:mm:ss");
				summaryCell(summaryFormat.format(overview.getStartDate()),true);
				out.println("</td>");

				
				
				
				summaryCell(summaryFormat.format(overview.getEndDate()),true);
				out.println("</td>");

				time_start = Math.min(overview.getStartDate().getTime(),
						time_start);
				time_end = Math.max(overview.getEndDate().getTime(), time_end);
				/*summaryCell(
                                             formatter.format((overview.getEndDate().getTime() - overview
                                                           .getStartDate().getTime()) / 1000.)
                                                           + " seconds", true);*/
				summaryCell(millisToTimeConversion((overview.getEndDate().getTime() - overview
						.getStartDate().getTime()) / 1000), true);

				
				out.println("</tr>");
				testIndex++;
			}
		}
		if (qty_tests > 1) {
			out.println("<tr class=\"total\"><td>Total</td>");
			summaryCell(qty_pass_m, Integer.MAX_VALUE);
			//summaryCell(qty_pass_s, Integer.MAX_VALUE);
			summaryCell(qty_skip, 0);
			summaryCell(qty_fail, 0);
			//summaryCell(" ", true);
			summaryCell(" ", true);
			summaryCell(" ", true);
			//summaryCell(" ", true);
			/*summaryCell(
                                      formatter.format(((time_end - time_start) / 1000.) / 60.)
                                      + " minutes", true);*/
			summaryCell(millisToTimeConversion(((time_end - time_start) / 1000)), true);
			out.println("<td colspan=\"3\">&nbsp;</td></tr>");
		}
		out.println("</table>");
	}


	private void summarycell(String suiteDate, boolean b) {
		out.print("<td class=\"numi" + (b ? "" : "_attn") + "\">" + suiteDate
				+ "</td>");
		
	}

	private void summaryCell(String[] val) {
		StringBuffer b = new StringBuffer();
		for (String v : val) {
			b.append(v + " ");
		}
		summaryCell(b.toString(), true);
	}

	private void summaryCell(String v, boolean isgood) {
		out.print("<td class=\"numi" + (isgood ? "" : "_attn") + "\">" + v
				+ "</td>");
	}

	private void startSummaryRow(String label) {
		row += 1;
		out.print("<tr"
				+ (row % 2 == 0 ? " class=\"stripe\"" : "")
				+ "><td style=\"text-align:left;padding-right:2em\"><a href=\"#t"
				+ testIndex + "\"><b>" + label + "</b></a>" + "</td>");

	}

	private void summaryCell(int v, int maxexpected) {
		summaryCell(String.valueOf(v), v <= maxexpected);
	}

	private void tableStart(String cssclass, String id) {
		out.println("<table cellspacing=\"0\" cellpadding=\"0\""
				+ (cssclass != null ? " class=\"" + cssclass + "\""
						: " style=\"padding-bottom:2em\"")
				+ (id != null ? " id=\"" + id + "\"" : "") + ">");
		row = 0;
	}

	private void tableColumnStart(String label) {
		out.print("<th>" + label + "</th>");
	}

	private void titleRow(String label, int cq) {
		titleRow(label, cq, null);
	}

	private void titleRow(String label, int cq, String id) {
		out.print("<tr");
		if (id != null) {
			out.print(" id=\"" + id + "\"");
		}
		out.println("><th colspan=\"" + cq + "\">" + label + "</th></tr>");
		row = 0;
	}

	/** Starts HTML stream */
	protected void startHtml(PrintWriter out) {
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<title>TestNG Report</title>");
		out.println("<style type=\"text/css\">");
		out.println("table {margin-bottom:10px;border-collapse:collapse;empty-cells:show}");
		out.println("td,th {border:1px solid #009;padding:.25em .5em}");
		out.println(".result th {vertical-align:bottom}");
		out.println(".param th {padding-left:1em;padding-right:1em}");
		out.println(".param td {padding-left:.5em;padding-right:2em}");
		out.println(".stripe td,.stripe th {background-color: #E6EBF9}");
		out.println(".numi,.numi_attn {text-align:right}");
		out.println(".total td {font-weight:bold}");
		out.println(".passedodd td {background-color: #0A0}");
		out.println(".passedeven td {background-color: #3F3}");
		out.println(".skippedodd td {background-color: #CCC}");
		out.println(".skippedodd td {background-color: #DDD}");
		out.println(".failedodd td,.numi_attn {background-color: #F33}");
		out.println(".failedeven td,.stripe .numi_attn {background-color: #D00}");
		out.println(".stacktrace {white-space:pre;font-family:monospace}");
		out.println(".totop {font-size:85%;text-align:center;border-bottom:2px solid #000}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
	}

	/** Finishes HTML stream */
	protected void endHtml(PrintWriter out) {
		out.println("<center> Report customized </center>");
		out.println("</body></html>");
	}

	// ~ Inner Classes --------------------------------------------------------
	/** Arranges methods by classname and method name */
	private class TestSorter implements Comparator<IInvokedMethod> {
		// ~ Methods
		// -------------------------------------------------------------


		/** Arranges methods by classname and method name */
		@Override
		public int compare(IInvokedMethod obj1, IInvokedMethod obj2) {
			int r = obj1.getTestMethod().getTestClass().getName().compareTo(obj2.getTestMethod().getTestClass().getName());
			return r;
		}
	}
	private class TestMethodSorter implements Comparator<ITestNGMethod> {
		@Override
		public int compare(ITestNGMethod obj1, ITestNGMethod obj2) {
			int r = obj1.getTestClass().getName().compareTo(obj2.getTestClass().getName());
			if (r == 0) {
				r = obj1.getMethodName().compareTo(obj2.getMethodName());
			}
			return r;
		}
	}

	private class TestResultsSorter implements Comparator<ITestResult> {
		@Override
		public int compare(ITestResult obj1, ITestResult obj2) {
			int result = obj1.getTestClass().getName().compareTo(obj2.getTestClass().getName());
			if (result == 0) {
				result = obj1.getMethod().getMethodName().compareTo(obj2.getMethod().getMethodName());
			}
			return result;
		}
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	


}