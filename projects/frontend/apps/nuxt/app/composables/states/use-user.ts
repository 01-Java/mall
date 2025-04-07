import { defineStore } from "pinia";

interface Profile {
	id: string;
	account: string;
	mobile: string;
	token: string;
	avatar: string;
	nickname: string;
	gender: string;
	birthday: string;
	cityCode: string;
	provinceCode: string;
	profession: string;
}

export const useUserStore = defineStore("user", () => {
	const profile = ref<Profile>({
		id: "",
		account: "",
		mobile: "",
		token: "",
		avatar: "",
		nickname: "",
		gender: "",
		birthday: "",
		cityCode: "",
		provinceCode: "",
		profession: "",
	});

	function setUser(payload: Profile) {
		profile.value = payload;
	}

	function logout() {
		profile.value = {
			id: "",
			account: "",
			mobile: "",
			token: "",
			avatar: "",
			nickname: "",
			gender: "",
			birthday: "",
			cityCode: "",
			provinceCode: "",
			profession: "",
		};
	}

	return {
		profile,
		setUser,
		logout,
	};
});
