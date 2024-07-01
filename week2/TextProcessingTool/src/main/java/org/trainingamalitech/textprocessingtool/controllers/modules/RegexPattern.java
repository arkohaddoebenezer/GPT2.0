package org.trainingamalitech.textprocessingtool.controllers.modules;

import java.util.Objects;

public class RegexPattern {
    private String pattern;

    public RegexPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        RegexPattern that = (RegexPattern) o;

        return Objects.equals(pattern, that.pattern);
    }

    @Override
    public int hashCode() {
        return pattern != null ? pattern.hashCode() : 0;
    }

    @Override
    public String toString() {
        return pattern;
    }

}
