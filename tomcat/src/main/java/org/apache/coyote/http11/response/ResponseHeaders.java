package org.apache.coyote.http11.response;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.coyote.http11.HttpHeaderKey;

public class ResponseHeaders {

    private static final String HEADER_SEPARATOR = ": ";
    public static final String LINE_BREAK = " \r\n";

    private final Map<HttpHeaderKey, String> headers = new LinkedHashMap<>();

    public void add(HttpHeaderKey name, String value) {
        headers.put(name, value);
    }

    public String getHeaderResponse() {
        return headers.entrySet().stream()
                .map(entry -> entry.getKey().getName() + HEADER_SEPARATOR + entry.getValue())
                .collect(Collectors.joining(LINE_BREAK));
    }
}
