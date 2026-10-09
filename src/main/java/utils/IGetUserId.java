package utils;

import dto.CreateUserResult;
import dto.User;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

import static utils.UserFactory.positiveUser;

public interface IGetUserId extends BaseApi {
    default String getUserId() {
        User user = positiveUser();
        RequestBody requestBody =
                RequestBody.create(GSON.toJson(user), JSON);
        Request request = new Request.Builder()
                .url(BASE_URL + REGISTRATION_URL)
                .post(requestBody)
                .build();
        Response response;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CreateUserResult createUserResult;
        try {
            createUserResult = GSON.fromJson(response
                    .body().string(), CreateUserResult.class);
            return createUserResult.getUserId();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
