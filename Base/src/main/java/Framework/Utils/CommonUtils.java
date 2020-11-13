package Framework.Utils;


import Framework.Custom.Config;
import Framework.Custom.DriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CommonUtils {

	
	
	public static void createDirectory(String directoryPath) {
		File file = new File(directoryPath);
		if (!file.exists()) {
			file.mkdirs();
		}
	}
	
	public static String getPathWithValidSeperator(String path) {

		final String UNIX_FILE_SEPARATOR = "/";
		final String WINDOWS_FILE_SEPARATOR = "\\\\";
		String changedPath = path;

		if (File.separator.equals(WINDOWS_FILE_SEPARATOR))
			changedPath = path.replaceAll(UNIX_FILE_SEPARATOR, Matcher.quoteReplacement(WINDOWS_FILE_SEPARATOR));
		if (File.separator.equals(UNIX_FILE_SEPARATOR))
			changedPath = path.replaceAll(WINDOWS_FILE_SEPARATOR, Matcher.quoteReplacement(UNIX_FILE_SEPARATOR));
		return changedPath;
	}

	
	public static void zip(String dirPath) {
		Path sourceDir = Paths.get(dirPath);
		String zipFileName = dirPath.concat(".zip");
		try {
			ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(zipFileName));
			Files.walkFileTree(sourceDir, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
					try {
						Path targetFile = sourceDir.relativize(file);
						outputStream.putNextEntry(new ZipEntry(targetFile.toString()));
						byte[] bytes = Files.readAllBytes(file);
						outputStream.write(bytes, 0, bytes.length);
						outputStream.closeEntry();
					} catch (IOException e) {
						e.printStackTrace();
					}
					return FileVisitResult.CONTINUE;
				}
			});
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to take screenshot of the failed step.
	 *
	 * @param result
	 *            The ITestResult object used to verify the outcome of the Test.
	 * @return The destination path of the snapshot.
	 */
	public static String createScreenshot(final ITestResult result) throws IOException {
		final WebDriver driver = DriverManager.getCurrentWebDriver();
		final DateFormat timeFormat = new SimpleDateFormat("MM.dd.yyyy HH-mm-ss");
		final String fileName = result.getMethod().getMethodName() + "_" + timeFormat.format(new Date()) + ".png";
		File scrFile;
		if (driver.getClass().equals(RemoteWebDriver.class)) {
			scrFile = ((TakesScreenshot) new Augmenter().augment(driver)).getScreenshotAs(OutputType.FILE);
		} else {
			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		}
		String Filepath = Config.FAILED_TESTCASE_SCREENSHOT_PATH + fileName;
		String destination = Config.EXTENT_REPORT_PATH + Filepath;
		System.out.println("Destination is " + destination);
		File finalDestination = new File(destination);
		FileUtils.copyFile(scrFile, finalDestination);
		return Filepath;
	}
		
}
