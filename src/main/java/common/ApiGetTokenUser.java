package common;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;

public class ApiGetTokenUser {
    String URL = "https://unknown/auth?casKey=";

    @DisplayName("Получение access-token")
    public String getAccessToken() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("unknown","unknown")
                .addFormDataPart("unknown","unknown")
                .build();
        Request request = new Request.Builder()
                .url("https://unknown/token")
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        String results = response.body().string();

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        String response_result = results;
        JsonNode rootNode = mapper.readTree(response_result);

        return rootNode.get("access_token").asText();
    }

    @DisplayName("ссылка для авторизации")
    public String getCasKey() throws IOException {
        String token = getAccessToken();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "unknown");
        Request request = new Request.Builder()
                .url("unknown")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Authorization", "Bearer" + " " + token)
                .build();
        Response response2 = client.newCall(request).execute();
        String results = response2.body().string();

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        String response_cas = results;
        JsonNode rootNode = mapper.readTree(response_cas);

        return URL + rootNode.get("cas_key").asText();

    }
}
