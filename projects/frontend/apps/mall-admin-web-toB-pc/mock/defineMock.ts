import path from "node:path";
import type { AxiosResponse } from "axios";

import type { RequiredPick } from "type-plus";

import { createDefineMock } from "vite-plugin-mock-dev-server";

export type MockResponse<T> = RequiredPick<
  Partial<AxiosResponse<T>>,
  "data" | "status"
>;

/**
 * @see https://vscode.dev/github/youlaitech/vue3-element-admin/blob/master/mock/base.ts
 */
export const defineMock = createDefineMock((mock) => {
  // 拼接url
  // mock.url = path.join(
  //   import.meta.env.VITE_APP_BASE_API + "/api/v1/",
  //   mock.url
  // );
});
