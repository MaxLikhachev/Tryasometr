package su.vistar.logging.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LogLevel {
    WARN("WARN"),
    ERROR("ERROR"),
    TRACE("TRACE"),
    DEBUG("DEBUG"),
    INFO("INFO");
    private String level;
}
