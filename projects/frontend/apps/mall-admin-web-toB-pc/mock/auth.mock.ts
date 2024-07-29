// import { defineMock, type MockResponse } from "@/utils";
import { defineMock, type MockResponse } from "./defineMock";

// import type { CaptchaResult, LoginData, LoginResult } from "@/api/auth/types";

export default defineMock({
  url: "/youlai-auth/oauth2/token",
  method: "POST",

  body(request): MockResponse<LoginResult> {
    return {
      status: 200,
      data: {
        access_token: "access_token-rzn",
        refresh_token: "refresh_token-rzn",
        token_type: "token_type-rzn",
        expires: 100,
      },
    };
  },
});
