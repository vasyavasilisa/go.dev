package framework.enums;

import framework.Logger;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;


public enum Script {
    RETURN_DOC_STATE("returnDocState.js");

    private String script;

    Script(String script) {
        this.script = script;
    }

    public String getScript() {
        String result = null;
        try {
            InputStream inputStream = getClass().getResource("/js/" + script).openStream();
            result = IOUtils.toString(inputStream, "UTF-8");
        } catch (IOException e) {
            Logger.getInstance().warn(e.getMessage());
        }
        return result == null ? "" : result;
    }
}
