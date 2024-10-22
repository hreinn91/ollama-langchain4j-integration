package com.hreinn.backend.config;

import com.hreinn.backend.domain.StreamingChatModel;
import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FunctionCallingRuntimeHints implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        var mcs = MemberCategory.values();
        hints.reflection().registerType(StreamingChatModel.class, mcs);
        try {
            hints.reflection().registerMethod(StreamingChatModel.class.getMethod("getOfficeTemperature"), ExecutableMode.INVOKE);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
