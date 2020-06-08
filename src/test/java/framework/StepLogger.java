package framework;

public class StepLogger {
    private static ThreadLocal<StepLogger> instance = ThreadLocal.withInitial(StepLogger::new);
    private int stepNumber;

    private StepLogger() {
        resetStepCounter();
    }

    public static StepLogger getInstance() {
        return instance.get();
    }

    public void logStep(String message) {
        Logger.getInstance().step(stepNumber, message);
        stepNumber++;
    }

    public void resetStepCounter() {
        stepNumber = 1;
    }
}