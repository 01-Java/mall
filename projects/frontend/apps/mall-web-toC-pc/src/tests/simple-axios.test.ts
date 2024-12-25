import axios from "axios";

function createAxiosInstance() {
	const instance = axios.create({
		baseURL: "https://pcapi-xiaotuxian-front-devtest.itheima.net",

		/** 请求超时时间 */
		timeout: 10000,

		/** 允许跨域 */
		// withCredentials: true,
	});

	return instance;
}

function main() {
	// const url = `https://pcapi-xiaotuxian-front-devtest.itheima.net/home/category/head`;
	const url = `https://pcapi-xiaotuxian-front-devtest.itheima.net/home/hot`;

	axios({
		url,
		method: "get",
	}).then((res) => {
		console.log(" ? ", res.data);
	});

	// axios.get(url).then((res) => {
	// 	console.log(" ? ", res);
	// });
	// fetch(url).then((res) => {
	// 	console.log(" ? ", res);
	// 	res.body
	// 		?.getReader()
	// 		.read()
	// 		.then((res) => {
	// 			console.log(" ? ", res);
	// 		});
	// });
}

main();
