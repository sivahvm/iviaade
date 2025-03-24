package com.ibm.ivia.config.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
public class ExecuteCommandProcess {
	Process process;
	private final Logger log = LoggerFactory.getLogger(getClass());

public void executecommand(String command) {
	boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
	String homeDirectory="";
    try {
	if (isWindows) {

			process = Runtime.getRuntime()
			    .exec(String.format("cmd.exe /c dir %s | findstr \"Desktop\"", homeDirectory));
		
	} else {
	    process = Runtime.getRuntime()
	        .exec(String.format("/bin/sh -c ls %s | grep \"Desktop\"", homeDirectory));
	}
	
    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    log.info("OutPut:>                     : "+homeDirectory);
	/* ProcessBuilder builder = new ProcessBuilder();
	if (isWindows) {
	    builder.command("cmd.exe", "/c", "dir");
	} else {
	    builder.command("sh", "-c", "ls");
	}
	builder.directory(new File(System.getProperty("user.home")));
	Process process = builder.start();
	StreamGobbler streamGobbler = 
	  new StreamGobbler(process.getInputStream(), System.out::println);
	Executor executor = Executors.newSingleThreadExecutor();

	Future<?> future = executorService.submit(streamGobbler);

	int exitCode = process.waitFor();

	assertDoesNotThrow(() -> future.get(10, TimeUnit.SECONDS));
	assertEquals(0, exitCode);  */
}

private static class StreamGobbler implements Runnable {
    private InputStream inputStream;
    private Consumer<String> consumer;

    public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
        this.inputStream = inputStream;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        new BufferedReader(new InputStreamReader(inputStream)).lines()
          .forEach(consumer);
    }
}

public  String execCmd(String cmd) {
	
	boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
	String homeDirectory="";
    String result = null;


	if (isWindows) {

		homeDirectory="cmd.exe "+cmd;
		
	} else {
		homeDirectory=""+cmd;
	}
	
    log.info("Input:>                     : "+homeDirectory);

    
    try (InputStream inputStream = Runtime.getRuntime().exec(homeDirectory).getInputStream();
            Scanner s = new Scanner(inputStream).useDelimiter("\\A")) {
        result = s.hasNext() ? s.next() : null;
    } catch (IOException e) {
        e.printStackTrace();
    }
    log.info("OutPut:>                     : "+result);

    return result;
}


public  void unzip(String zipFile, String destFolder) throws IOException {
    try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
        ZipEntry entry;
        byte[] buffer = new byte[1024];
        while ((entry = zis.getNextEntry()) != null) {
            File newFile = new File(destFolder + File.separator + entry.getName());
            if (entry.isDirectory()) {
                newFile.mkdirs();
            } else {
                new File(newFile.getParent()).mkdirs();
                try (FileOutputStream fos = new FileOutputStream(newFile)) {
                    int length;
                    while ((length = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, length);
                    }
                }
            }
        }
    }
}
}