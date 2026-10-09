package utils;

import dto.TokenDto;
import dto.User;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public interface IGetToken extends BaseApi{
    default TokenDto getTokenAfterLogin(){
        User user = User.builder()
                .userName("vbnghtyu123@gmail.com")
                .password("Qwerty123!")
                .build();
        RequestBody requestBody =
                RequestBody.create(GSON.toJson(user), JSON);
        Request request = new Request.Builder()
                .url(BASE_URL + GENERATE_TOKEN_URL)
                .post(requestBody)
                .build();
        Response response;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TokenDto tokenDto;
        try {
            tokenDto= GSON.fromJson(response.body().string(), TokenDto.class);
            return tokenDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
