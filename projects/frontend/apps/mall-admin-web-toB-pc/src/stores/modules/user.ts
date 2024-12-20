import { loginApi, logoutApi } from "@/apis/auth";
import { getUserInfoApi } from "@/apis/system/user";
import { resetRouter } from "@/router";
import { store } from "@/store";

import { LoginData } from "@/apis/auth/types";
import { UserInfo } from "@/apis/system/user/types";

export const useUserStore = defineStore("user", () => {
	const user: UserInfo = {
		roles: [],
		perms: [],
	};

	/**
	 * 登录
	 *
	 * @param {LoginData}
	 * @returns
	 */
	function login(loginData: LoginData) {
		return new Promise<void>((resolve, reject) => {
			loginApi(loginData)
				.then(({ data }) => {
					const { token_type, access_token } = data;
					localStorage.setItem("accessToken", token_type + " " + access_token); // Bearer eyJhbGciOiJIUzI1NiJ9.xxx.xxx
					resolve();
				})
				.catch((error) => {
					reject(error);
				});
		});
	}

	// 获取信息(用户昵称、头像、角色集合、权限集合)
	function getUserInfo() {
		return new Promise<UserInfo>((resolve, reject) => {
			getUserInfoApi()
				.then(({ data }) => {
					if (!data) {
						reject("Verification failed, please Login again.");
						return;
					}
					if (!data.roles || data.roles.length <= 0) {
						reject("getUserInfo: roles must be a non-null array!");
						return;
					}
					Object.assign(user, { ...data });
					resolve(data);
				})
				.catch((error) => {
					reject(error);
				});
		});
	}

	// user logout
	function logout() {
		return new Promise<void>((resolve, reject) => {
			logoutApi()
				.then(() => {
					localStorage.setItem("accessToken", "");
					location.reload(); // 清空路由
					resolve();
				})
				.catch((error) => {
					reject(error);
				});
		});
	}

	// remove token
	function resetToken() {
		return new Promise<void>((resolve) => {
			localStorage.setItem("accessToken", "");
			resetRouter();
			resolve();
		});
	}

	return {
		user,
		login,
		getUserInfo,
		logout,
		resetToken,
	};
});

// 非setup
export function useUserStoreHook() {
	return useUserStore(store);
}
