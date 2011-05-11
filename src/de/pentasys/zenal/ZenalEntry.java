package de.pentasys.zenal;

import org.joda.time.DateTime;

import de.pentasys.zenal.builder.Category;
import de.pentasys.zenal.builder.Project;
import de.pentasys.zenal.builder.TimespanDateTime;

public class ZenalEntry {

    private final DateTime from;
    private final DateTime till;
    private final String description;
    private final Project project;
    private final Category category;

    public ZenalEntry(final Project project, final DateTime from, final DateTime till, final String description,
            final Category category) {
        this.project = project;
        this.from = from;
        this.till = till;
        this.description = description;
        this.category = category;
    }

    public ZenalEntry(final Project project, final TimespanDateTime timeSpan, final String description,
            final Category category) {
        this(project, timeSpan.getFrom(), timeSpan.getTill(), description, category);
    }

    public DateTime getFrom() {
        return from;
    }

    public DateTime getTill() {
        return till;
    }

    public String getDescription() {
        return description;
    }

    public String getProjectId() {
        return project.getProjectId();
    }

    public String getCategory() {
        return category.getCategory();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((from == null) ? 0 : from.hashCode());
        result = prime * result + ((project == null) ? 0 : project.hashCode());
        result = prime * result + ((till == null) ? 0 : till.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ZenalEntry other = (ZenalEntry) obj;
        if (category != other.category) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (from == null) {
            if (other.from != null) {
                return false;
            }
        } else if (!from.equals(other.from)) {
            return false;
        }
        if (project != other.project) {
            return false;
        }
        if (till == null) {
            if (other.till != null) {
                return false;
            }
        } else if (!till.equals(other.till)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ZenalEntry [from=").append(from).append(", till=").append(till).append(", description=")
                .append(description).append(", project=").append(project).append(", category=").append(category)
                .append("]");
        return builder.toString();
    }

}
