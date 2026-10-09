package utils;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

public interface BaseApi {
    String BASE_URL = "https://demoqa.com";
    String REGISTRATION_URL = "/Account/v1/User";
    String LOGIN_URL = "/Account/v1/Authorized";
    String GENERATE_TOKEN_URL = "/Account/v1/GenerateToken";
    String GET_ALL_BOOKS_URL = "/BookStore/v1/Books";

    MediaType JSON = MediaType.get("application/json");
    OkHttpClient OK_HTTP_CLIENT = new OkHttpClient();
    Gson GSON = new Gson();
    String AUTH = "Authorization";

    MediaType TEXT = MediaType.get("text/plain");

}
