package com.example.waimaicommodity;

import com.alibaba.fastjson2.JSON;
import com.example.waimaicommodity.common.util.ConvertUtil;
import com.example.waimaicommodity.common.util.RedisUtil;
import com.example.waimaicommodity.entity.Food;
import com.example.waimaicommodity.service.FoodService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class WaimaiCommodityApplicationTests {

	@Autowired
	private FoodService foodService;

	@Autowired
	private ConvertUtil<Food> convertUtil;

	@Autowired
	private RedisUtil redisUtil;



	@Test
	void contextLoads() {

		/*Result foodfind = foodService.foodfind();

		System.out.println(foodfind);*/

		List<Food> foods = new ArrayList<>();

		Food food = new Food();
		food.setCover("467");
		food.setId(64646);
		food.setTitle("火鸡面2");

		foods.add(food);

		String s = convertUtil.ListToString(foods);
		System.out.println(s);

		List<Food> foodList = convertUtil.StringToList(s ,new Food());

		for (Food food1 : foodList) {
			System.out.println(food1.getTitle());
		}

		Map<String, String> map = new HashMap<>();
		map.put(food.getId().toString() ,convertUtil.ListToString(foods));

		int x = 0;
		String test = redisUtil.setHash("test", map, x);

		List test1 = redisUtil.getHash("test", x, food.getId().toString());
		for (Object o : test1) {
			System.out.println(o);
		}
		System.out.println("------------");

	}

	@Test
	void srviceTest(){

		/*Result foodfind = foodService.foodfind();*/
		List test1 = redisUtil.getHash("foodlist", 0, "20");
		for (Object o : test1) {
			Food food = JSON.parseObject(o.toString(), Food.class);
			System.out.println(food);
		}
	}



}
