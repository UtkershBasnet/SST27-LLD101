package com;

import java.nio.file.Path;

import com.example.report.AuditLog;
import com.example.report.JsonWriter;
import com.example.report.Zipper;

public class ReportBundleFacade {
    public static Path export(java.util.Map<String,Object> data, java.nio.file.Path outDir, String baseName){
        JsonWriter jw = new JsonWriter(); 
        Zipper z = new Zipper(); 
        AuditLog log = new AuditLog();
        Path json = jw.write(data,outDir,baseName);
        Path zip = z.zip(json,Path.of("out", "report.zip"));
        log.log("exported " + zip);
        System.out.println("DONE " + zip);
        return zip;
    }
}
