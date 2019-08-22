package su.vistar.logging.service;

import org.springframework.stereotype.Service;
import su.vistar.logging.model.Log;
import su.vistar.logging.model.LogLevel;
import su.vistar.logging.repository.LogRepository;

import java.util.Date;

@Service
public class LogService {
    private final LogRepository loggerRepository;
    private String className;
    public LogService(LogRepository loggerRepository) {
        this.loggerRepository = loggerRepository;
    }

    public void setClass(Class clazz) {
        this.className = clazz.getName();
    }

    public void info(String message) {
        loggerRepository.save(new Log(new Date().toString(), LogLevel.INFO.toString(), className, message));
    }
    public void warn(String message) {
        loggerRepository.save(new Log(new Date().toString(), LogLevel.WARN.toString(), className, message));
    }
    public void error(String message) {
        loggerRepository.save(new Log(new Date().toString(), LogLevel.ERROR.toString(), className, message));
    }
    public void debug(String message) {
        loggerRepository.save(new Log(new Date().toString(), LogLevel.DEBUG.toString(), className, message));
    }
    public void trace(String message) {
        loggerRepository.save(new Log(new Date().toString(), LogLevel.TRACE.toString(), className, message));
    }
}

