package flowdroid.helper;

import soot.jimple.Stmt;

import java.io.File;
import java.util.*;

public class DataParsing {
    private String apkName;
    private String apkPath;
    private int manifestNum;
    private int flowNum;
    private double flowTime;
    private Set<Stmt> flowSources = new HashSet<Stmt>();
    private Set<Stmt> flowSinks = new HashSet<Stmt>();
    private List<String> manifestResults = new ArrayList<String>();
    private List<String> flowResults = new ArrayList<String>();
    private String mode;

    public DataParsing() {

    }

    public DataParsing(String apkPath) {
        this.apkPath = apkPath;
        File apkFile = new File(apkPath);
        this.apkName = apkFile.getName();
    }

    public String apkNameToString() {
        StringBuilder result = new StringBuilder();
        result.append(this.apkName);

        return result.toString();
    }

    public String apkPathToString() {
        StringBuilder result = new StringBuilder();
        result.append(this.apkPath);

        return result.toString();
    }

    public String sourcesToString() {
        if (this.flowSources == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Stmt source : this.flowSources) {
            if (first) {
                first = false;
            } else {
                result.append(" && ");
            }
            result.append(source);
        }

        return result.toString();
    }

    public String sinksToString() {
        if (this.flowSinks == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Stmt sink : this.flowSinks) {
            if (first) {
                first = false;
            } else {
                result.append(" && ");
            }
            result.append(sink);
        }

        return result.toString();
    }

    public String manifestToString() {
        if (this.manifestResults == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (String string : this.manifestResults) {
            if (first) {
                first = false;
            } else {
                result.append(" && ");
            }
            result.append(string);
        }

        return result.toString();
    }

    public String flowToString() {
        if (this.flowResults == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (String string : this.flowResults) {
            if (first) {
                first = false;
            } else {
                result.append(" && ");
            }
            result.append(string);
        }

        return result.toString();
    }

    public void savaFlowResult(ExtractSourceSinkFlow ESSF) {
        this.flowResults = ESSF.getFlowResult().getExtractContents();
        this.flowTime = ESSF.getFlowResult().getCostTime();
        this.flowSources = ESSF.getFlowResult().getSelSources();
        this.flowSinks = ESSF.getFlowResult().getSelSinks();
        this.flowTime = ESSF.getFlowResult().getCostTime();
    }

    public List<String> toStringList() {
        return Arrays.asList(this.apkNameToString(), this.manifestToString(),
                this.flowToString(), this.sourcesToString(), this.sinksToString(),
                String.valueOf(this.getFlowTime()), this.getMode());
    }

    public String getApkName() {
        return apkName;
    }

    public void setApkName(String apkName) {
        this.apkName = apkName;
    }

    public String getApkPath() {
        return apkPath;
    }

    public void setApkPath(String apkPath) {
        this.apkPath = apkPath;
        File apkFile = new File(apkPath);
        this.apkName = apkFile.getName();
    }

    public int getManifestNum() {
        return manifestNum;
    }

    public void setManifestNum(int manifestNum) {
        this.manifestNum = manifestNum;
    }

    public int getFlowNum() {
        return flowNum;
    }

    public void setFlowNum(int flowNum) {
        this.flowNum = flowNum;
    }

    public double getFlowTime() {
        return flowTime;
    }

    public void setFlowTime(double flowTime) {
        this.flowTime = flowTime;
    }

    public Set<Stmt> getFlowSources() {
        return flowSources;
    }

    public void setFlowSources(Set<Stmt> flowSources) {
        this.flowSources = flowSources;
    }

    public Set<Stmt> getFlowSinks() {
        return flowSinks;
    }

    public void setFlowSinks(Set<Stmt> flowSinks) {
        this.flowSinks = flowSinks;
    }

    public List<String> getManifestResults() {
        return manifestResults;
    }

    public void setManifestResults(List<String> manifestResults) {
        this.manifestResults = manifestResults;
        this.manifestNum = manifestResults.size();
    }

    public List<String> getFlowResults() {
        return flowResults;
    }

    public void setFlowResults(List<String> flowResults) {
        this.flowResults = flowResults;
        this.flowNum = flowResults.size();
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
