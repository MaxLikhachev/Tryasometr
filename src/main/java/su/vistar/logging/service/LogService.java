package su.vistar.logging.service;

import org.springframework.stereotype.Service;
import su.vistar.logging.model.Log;
import su.vistar.logging.model.LogLevel;
import su.vistar.logging.repository.LogRepository;

import java.util.Date;

@Service
public class LogService {
    private final LogRepository loggerRepository;

    public LogService(LogRepository loggerRepository) {
        this.loggerRepository = loggerRepository;
    }

    public void info(String message, String path) {
        loggerRepository.save(new Log(new Date().toString(), LogLevel.INFO.toString(), path, message));
    }
    public void warn(String message, String path) {
        loggerRepository.save(new Log(new Date().toString(), LogLevel.WARN.toString(), path, message));
    }
    public void error(String message, String path) {
        loggerRepository.save(new Log(new Date().toString(), LogLevel.ERROR.toString(), path, message));
    }
    public void debug(String message, String path) {
        loggerRepository.save(new Log(new Date().toString(), LogLevel.DEBUG.toString(), path, message));
    }
    public void trace(String message, String path) {
        loggerRepository.save(new Log(new Date().toString(), LogLevel.TRACE.toString(), path, message));
    }
}

