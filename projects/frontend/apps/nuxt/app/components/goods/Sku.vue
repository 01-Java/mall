<script setup lang="ts">
import { ref, watch } from 'vue';

// 规格值类型
interface SpecValue {
  name: string;
  picture?: string;
  disabled?: boolean;
  selected?: boolean;
}

// 规格类型
export interface SkuSpec {
  name: string;
  values: SpecValue[];
}

// SKU数据类型
export interface SkuData {
  id: string;
  skuId: string;
  price: string;
  oldPrice: string;
  inventory: number;
  specs: {
    name: string;
    valueName: string;
  }[];
}

// 组件Props类型
interface Props {
  goods: Record<string, any>;
  skuId: string;
  specs: SkuSpec[];
  skus: SkuData[];
}

// 直接解构defineProps，Vue会自动保持响应性
const { goods, skuId, specs, skus } = defineProps<Props>();

const emit = defineEmits<{
  (e: 'change', sku: SkuData): void
}>();

// 1. 选中记录
const selectedSpec = ref<Record<string, string>>({});

// 类型安全的访问函数，避免类型错误
const getSelectedSpecValue = (specName: string): string | undefined => {
  return selectedSpec.value[specName];
};

// 判断规格是否被选中
const isSpecSelected = (specName: string, valueName: string): boolean => {
  return getSelectedSpecValue(specName) === valueName;
};

// 2. 监听变化，判断规格组合是否有效
watch(
  () => skuId,
  (newVal) => {
    if (newVal && skus.length) {
      // 获取当前SKU对应的规格选项
      const sku = skus.find(item => item.skuId === newVal);
      if (sku) {
        // 遍历规格，选中传入的skuId对应的规格选项
        selectedSpec.value = getSelectedSpec(sku.specs);
      }
    } else {
      selectedSpec.value = {};
    }
  },
  { immediate: true }
);

// 根据specs数组生成selectedSpec对象
const getSelectedSpec = (specs: { name: string; valueName: string }[]) => {
  const result: Record<string, string> = {};
  specs.forEach(spec => {
    result[spec.name] = spec.valueName;
  });
  return result;
};

// 3. 获取路径字典，用于确定库存
const pathMap = ref<Record<string, string>>({});
watch(
  () => skus,
  (newVal) => {
    const pathDict: Record<string, string> = {};
    if (newVal && newVal.length) {
      newVal.forEach(sku => {
        const specKeys = sku.specs.map(spec => `${spec.name}:${spec.valueName}`);
        const key = specKeys.join('_');
        pathDict[key] = sku.skuId;
      });
    }
    pathMap.value = pathDict;
  },
  { immediate: true }
);

// 4. 更新禁用状态
const updateDisabledStatus = () => {
  specs.forEach((spec) => {
    spec.values.forEach(val => {
      // 拷贝一份当前选中规格
      const selected = { ...selectedSpec.value };
      // 忽略当前选项，判断剩余规格是否可以组合
      selected[spec.name] = val.name;
      
      // 遍历其他规格是否可以组合成有效的sku
      val.disabled = !isValid(spec.name, selected);
    });
  });
};

// 检查规格组合是否有效
const isValid = (currentName: string, selected: Record<string, string>) => {
  // 获取当前所有可能的组合
  const keys = Object.keys(selected).filter(key => key !== currentName);
  
  // 如果只有一个规格，直接查询是否存在
  if (keys.length === 0) {
    const key = `${currentName}:${selected[currentName]}`;
    return !!pathMap.value[key];
  }
  
  // 检查是否有满足条件的组合
  let result = false;
  const combinations = getCombinations(keys, selected);
  combinations.forEach(combo => {
    const key = combo.join('_');
    if (pathMap.value[key]) {
      result = true;
    }
  });
  
  return result;
};

// 生成所有可能的规格组合
const getCombinations = (keys: string[], selected: Record<string, string>) => {
  const result: string[][] = [];
  
  // 遍历所有可能的规格组合
  const generateCombos = (index: number, current: string[]) => {
    if (index === keys.length) {
      result.push([...current]);
      return;
    }
    
    const key = keys[index];
    // 确保key存在于selected中
    if (key && key in selected) {
      const value = selected[key];
      current.push(`${key}:${value}`);
      generateCombos(index + 1, current);
      current.pop();
    }
  };
  
  generateCombos(0, []);
  return result;
};

// 5. 选择规格
const clickSpec = (spec: SkuSpec, val: SpecValue) => {
  if (val.disabled) return;
  
  if (selectedSpec.value[spec.name] === val.name) {
    // 再次点击取消选择
    const newSelected = { ...selectedSpec.value };
    delete newSelected[spec.name];
    selectedSpec.value = newSelected;
  } else {
    // 点击选择
    selectedSpec.value = {
      ...selectedSpec.value,
      [spec.name]: val.name
    };
  }
  
  // 找到对应的sku并触发change事件
  const validSelection = Object.keys(selectedSpec.value).length === specs.length;
  if (validSelection) {
    const key = specs
      .map(spec => `${spec.name}:${selectedSpec.value[spec.name]}`)
      .join('_');
    
    if (pathMap.value[key]) {
      const skuId = pathMap.value[key];
      const sku = skus.find(item => item.skuId === skuId);
      if (sku) {
        emit('change', sku);
      }
    }
  }
  
  // 更新禁用状态
  updateDisabledStatus();
};

// 初始化时更新禁用状态
updateDisabledStatus();
</script>

<template>
  <div class="goods-sku">
    <dl v-for="item in specs" :key="item.name">
      <dt>{{ item.name }}</dt>
      <dd>
        <template v-for="val in item.values" :key="val.name">
          <!-- 图片类型规格 -->
          <div
            v-if="val.picture"
            :class="[
              'sku-value', 
              { selected: isSpecSelected(item.name, val.name) }, 
              { disabled: val.disabled }
            ]"
            @click="clickSpec(item, val)"
          >
            <NuxtImg 
              :src="val.picture" 
              width="38"
              height="38"
              alt="" 
              :title="val.name"
            />
            <div class="sku-name">{{ val.name }}</div>
          </div>
          <!-- 文本类型规格 -->
          <div
            v-else
            :class="[
              'sku-value', 
              { selected: isSpecSelected(item.name, val.name) }, 
              { disabled: val.disabled }
            ]"
            @click="clickSpec(item, val)"
          >
            <span class="sku-name">{{ val.name }}</span>
          </div>
        </template>
      </dd>
    </dl>
  </div>
</template>

<style scoped lang="scss">
.goods-sku {
  padding-left: 10px;
  padding-top: 20px;

  dl {
    display: flex;
    padding-bottom: 20px;
    align-items: center;

    dt {
      width: 50px;
      color: #999;
    }

    dd {
      flex: 1;
      display: flex;
      flex-wrap: wrap;
      gap: 10px;
    }
  }

  .sku-value {
    display: inline-block;
    padding: 5px 18px;
    margin-right: 10px;
    cursor: pointer;
    border: 1px solid #e4e4e4;
    background-color: #fff;

    &.selected {
      background-color: #f5f5f5;
      color: $xtxColor;
      border-color: $xtxColor;
    }

    &.disabled {
      opacity: 0.6;
      border-style: dashed;
      cursor: not-allowed;
    }

    img {
      width: 38px;
      height: 38px;
      margin-right: 8px;
      vertical-align: middle;
    }

    .sku-name {
      display: inline-block;
      vertical-align: middle;
    }
  }
}
</style> 