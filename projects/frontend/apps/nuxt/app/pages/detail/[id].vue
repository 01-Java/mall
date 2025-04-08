<script setup lang="ts">
import { getDetailAPI, getDetailDirectAPI } from "@/apis/detail";
import type { ApifoxModel_goods } from "@/models/goods";
import { useCartStore } from "@/composables/states/use-cart";
import { ElMessage } from "element-plus";
import type { SkuData } from "@/components/goods/Sku.vue";

// 获取路由参数
const route = useRoute();
const id = route.params.id as string;

// 商品数据
const good = ref<Partial<ApifoxModel_goods>>({});
// 转换后的SKU数据
const goodSkus = ref<SkuData[]>([]);

// 将API返回的SKU数据转换为组件需要的格式
const mapSkuData = (skus: any[] = []): SkuData[] => {
  return skus.map(sku => ({
    id: sku.id,
    skuId: sku.id, // 使用id作为skuId
    price: String(sku.price),
    oldPrice: String(sku.oldPrice),
    inventory: sku.inventory,
    specs: sku.specs,
  }));
};

// 获取商品详情
const getGoods = async () => {
  try {
    // // 方案1：使用useAxios
    // const { data, error, execute } = await getDetailAPI(id, {
    //   immediate: false,
    //   resetOnExecute: false
    // });
		// await execute();
		// console.log('data', data.value);
    // if (data.value) {
    //   good.value = data.value;
    //   // 转换SKU数据
    //   if (good.value.skus) {
    //     goodSkus.value = mapSkuData(good.value.skus);
    //   }
    //   return; // 成功获取数据后退出
    // }

    // if (error.value) {
    //   console.warn('useAxios获取商品详情失败，尝试备选方案', error.value);
    //   // 如果useAxios方式失败，尝试方案2
    // }
    // 方案2：直接使用axios请求
    // console.log('正在使用备选方案获取商品详情...');
    const result = await getDetailDirectAPI<ApifoxModel_goods>(id);
		console.log('result', result);
    if (result) {
			// @ts-ignore
      good.value = result.result;
      // 转换SKU数据
      if (good.value.skus) {
        goodSkus.value = mapSkuData(good.value.skus);
      }
    }
  } catch (err) {
    console.error('获取商品详情出现异常', err);
    ElMessage.error('获取商品详情失败，请稍后再试');
  }
};

// 组件挂载时获取数据
onMounted(async () => {
  await getGoods();
});

// SKU选择相关逻辑
const skuObj = ref<Record<string, any>>({});
const skuChange = (sku: Record<string, any>) => {
  skuObj.value = sku;
};

// 商品数量
const num = ref(1);
const countChange = (count: number) => {
  num.value = count;
};

// 加入购物车
const cartStore = useCartStore();
const add = () => {
  if (skuObj.value.skuId) {
    // 规格选择完成，添加到购物车
    cartStore.addCart({
      id: good.value.id!,
      name: good.value.name!,
      picture: good.value.picture!,
      price: good.value.price!,
      count: num.value,
      skuId: skuObj.value.skuId,
      attrsText: skuObj.value.specsText,
      selected: true,
    });
    ElMessage.success("加入购物车成功");
  } else {
    // 提示用户选择规格
    ElMessage.warning("请选择完规格");
  }
};
</script>

<template>
  <div class="xtx-goods-page">
    <div class="container" v-if="good.id">
      <div class="bread-container">
        <el-breadcrumb separator=">">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item v-if="good.categories?.[1]" :to="{ path: `/category/${good.categories[1].id}` }">
            {{ good.categories[1].name }}
          </el-breadcrumb-item>
          <el-breadcrumb-item v-if="good.categories?.[0]" :to="{ path: `/category/sub/${good.categories[0].id}` }">
            {{ good.categories[0].name }}
          </el-breadcrumb-item>
          <el-breadcrumb-item>{{ good.name }}</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      
      <!-- 商品信息 -->
      <div class="info-container">
        <div>
          <div class="goods-info">
            <div class="media">
              <!-- 图片预览区 -->
              <GoodsImage :imageList="good.picture ? [good.picture] : []" />
              <!-- 统计数量 -->
              <ul class="goods-sales">
                <li>
                  <p>销量人气</p>
                  <p>{{ good.orderNum }}+</p>
                  <p><i class="iconfont icon-task-filling"></i>销量人气</p>
                </li>
                <li>
                  <p>商品评价</p>
                  <p>{{ good.orderNum }}+</p>
                  <p><i class="iconfont icon-comment-filling"></i>查看评价</p>
                </li>
                <li>
                  <p>收藏人气</p>
                  <p>{{ good.orderNum }}+</p>
                  <p><i class="iconfont icon-favorite-filling"></i>收藏商品</p>
                </li>
                <li>
                  <p>品牌信息</p>
                  <p>{{ good.brand?.name }}</p>
                  <p><i class="iconfont icon-dynamic-filling"></i>品牌主页</p>
                </li>
              </ul>
            </div>
            <div class="spec">
              <!-- 商品信息区 -->
              <p class="g-name">{{ good.name }}</p>
              <p class="g-desc">{{ good.desc }}</p>
              <p class="g-price">
                <span>{{ good.oldPrice }}</span>
                <span>{{ good.price }}</span>
              </p>
              <div class="g-service">
                <dl>
                  <dt>促销</dt>
                  <dd>12月好物放送，App领券购买直降120元</dd>
                </dl>
                <dl>
                  <dt>服务</dt>
                  <dd>
                    <span>无忧退货</span>
                    <span>快速退款</span>
                    <span>免费包邮</span>
                    <a href="javascript:;">了解详情</a>
                  </dd>
                </dl>
              </div>
              <!-- SKU组件 -->
              <GoodsSku 
                :goods="good" 
                :skus="goodSkus" 
                :specs="good.specs || []" 
                :skuId="''"
                @change="skuChange" 
              />
              <!-- 数量组件 -->
              <el-input-number 
                v-model="num" 
                :min="1" 
                @change="(value: number | undefined) => value !== undefined && countChange(value)" 
              />
              <!-- 按钮组件 -->
              <div>
                <el-button size="large" class="btn" @click="add">加入购物车</el-button>
              </div>
            </div>
          </div>
          <div class="goods-footer">
            <div class="goods-article">
              <!-- 商品详情 -->
              <div class="goods-tabs">
                <nav>
                  <a>商品详情</a>
                </nav>
                <div class="goods-detail">
                  <!-- 属性 -->
                  <ul class="attrs">
                    <li v-for="item in good.details?.properties" :key="item.value">
                      <span class="dt">{{ item.name }}</span>
                      <span class="dd">{{ item.value }}</span>
                    </li>
                  </ul>
                  <!-- 图片 -->
                  <div class="detail-content" v-if="good.details?.pictures" v-html="good.details.pictures.join('')"></div>
                </div>
              </div>
            </div>
            <div class="goods-aside">
              <!-- 24小时热榜 -->
              <GoodsHot :type="1" />
              <!-- 周热榜 -->
              <GoodsHot :type="2" />
            </div>
          </div>
        </div>
      </div>
    </div>
    <div v-else class="container">
      <el-empty description="商品信息加载中或不存在"></el-empty>
    </div>
  </div>
</template>

<style scoped lang="scss">
.xtx-goods-page {
  .goods-info {
    min-height: 600px;
    background: #fff;
    display: flex;

    .media {
      width: 580px;
      height: 600px;
      padding: 30px 50px;
    }

    .spec {
      flex: 1;
      padding: 30px 30px 30px 0;
    }
  }

  .goods-footer {
    display: flex;
    margin-top: 20px;

    .goods-article {
      width: 940px;
      margin-right: 20px;
    }

    .goods-aside {
      width: 280px;
      min-height: 1000px;
    }
  }

  .goods-tabs {
    min-height: 600px;
    background: #fff;

    nav {
      height: 70px;
      line-height: 70px;
      display: flex;
      border-bottom: 1px solid #f5f5f5;

      a {
        padding: 0 40px;
        font-size: 18px;
        position: relative;

        &:first-child {
          border-right: 1px solid #f5f5f5;
        }

        &.active {
          color: $xtxColor;
        }
      }
    }
  }

  .goods-detail {
    padding: 40px;

    .attrs {
      display: flex;
      flex-wrap: wrap;
      margin-bottom: 30px;

      li {
        display: flex;
        margin-bottom: 10px;
        width: 50%;

        .dt {
          width: 100px;
          color: #999;
        }

        .dd {
          flex: 1;
          color: #666;
        }
      }
    }

    .detail-content {
      img {
        max-width: 100%;
        height: auto;
      }
    }
  }

  .bread-container {
    padding: 25px 0;
  }

  .goods-sales {
    display: flex;
    width: 100%;
    height: 140px;

    li {
      flex: 1;
      text-align: center;
      line-height: 30px;

      i {
        font-size: 16px;
        color: $xtxColor;
        margin-right: 4px;
      }

      p {
        &:nth-child(2) {
          color: $priceColor;
          font-size: 18px;
        }

        &:nth-child(3) {
          color: #999;
          font-size: 12px;
        }
      }

      ~li {
        border-left: 1px solid #f5f5f5;
      }
    }
  }

  .g-name {
    font-size: 22px;
    margin-top: 20px;
  }

  .g-desc {
    color: #999;
    margin-top: 20px;
  }

  .g-price {
    margin-top: 20px;

    span {
      &::before {
        content: "¥";
        font-size: 14px;
      }

      &:first-child {
        color: #999;
        margin-right: 10px;
        text-decoration: line-through;
      }

      &:last-child {
        color: $priceColor;
        font-size: 22px;
      }
    }
  }

  .g-service {
    background: #f5f5f5;
    margin-top: 20px;

    dl {
      padding: 10px 0;
      display: flex;
      align-items: center;

      dt {
        width: 50px;
        color: #999;
      }

      dd {
        color: #666;

        &:last-child {
          span {
            margin-right: 10px;

            &::before {
              content: "•";
              color: $xtxColor;
              margin-right: 2px;
            }
          }

          a {
            color: $xtxColor;
          }
        }
      }
    }
  }

  .btn {
    margin-top: 20px;
  }
}
</style> 