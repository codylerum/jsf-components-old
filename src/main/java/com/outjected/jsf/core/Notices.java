package com.outjected.jsf.core;

import java.util.List;

/**
 * 
 * @author Cody Lerum
 * 
 */
public class Notices {

    private List<String> errors;
    private List<String> warnings;
    private List<String> infos;

    public Notices() {
    }

    public Notices(List<String> errors, List<String> warnings, List<String> infos) {
        this.errors = errors;
        this.warnings = warnings;
        this.infos = infos;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    public List<String> getInfos() {
        return infos;
    }

    public void setInfos(List<String> infos) {
        this.infos = infos;
    }

    public boolean containsErrors() {
        return errors != null && !errors.isEmpty();
    }

    public boolean containsWarnings() {
        return warnings != null && !warnings.isEmpty();
    }

    public boolean containsInfos() {
        return infos != null && !infos.isEmpty();
    }

    public boolean getContainsNotices() {
        return containsErrors() || containsWarnings() || containsInfos();
    }
}
