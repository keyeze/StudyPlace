package com.chan.Effective.Builder.Demo;

/**
 * Created by Osborn on 2017/7/18.
 */
public class NutritionFacts {
//	//成员
//	private final int servingSize;	//(mL)				required
//	private final int servings;		//(per container)	required
//	private final int calories;		//					optional
//	private final int fat;			//(g)				optional
//	private final int sodium;       //(mg)				optional
//	private final int carbohydrate;	//(g)				optional
	//
	private int servingSize;	//(mL)				required
	private int servings;		//(per container)	required
	private int calories;		//					optional
	private int fat;			//(g)				optional
	private int sodium;       //(mg)				optional
	private int carbohydrate;	//(g)				optional
	//成员Getter
	public int getServingSize() {
		return servingSize;
	}
	public int getServings() {
		return servings;
	}
	public int getCalories() {
		return calories;
	}
	public int getFat() {
		return fat;
	}
	public int getSodium() {
		return sodium;
	}
	public int getCarbohydrate() {
		return carbohydrate;
	}
	//1.利用构造方法初始化成员
	//麻烦。
	public NutritionFacts(int servingSize, int servings) {
		this(servingSize, servings, 0);
	}
	public NutritionFacts(int servingSize, int servings, int calories) {
		this(servingSize, servings, calories, 0);
	}
	public NutritionFacts(int servingSize, int servings, int calories, int fat) {
		this(servingSize, servings, calories, fat, 0);
	}
	public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodinum) {
		this(servingSize, servings, calories, fat, sodinum, 0);
	}
	public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
		this.servingSize = servingSize;
		this.servings = servings;
		this.calories = calories;
		this.fat = fat;
		this.sodium = sodium;
		this.carbohydrate = carbohydrate;
	}
	//2.利用JavaBean方法
	//方法不能让实例成员
	// 成为不可变的，需要额外的功夫去处理线程安全问题
	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}
	public void setServings(int servings) {
		this.servings = servings;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public void setFat(int fat) {
		this.fat = fat;
	}
	public void setSodium(int sodium) {
		this.sodium = sodium;
	}
	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}
	//3.利用Builder模式
	//既可以保证实例成员的不可变性，又方便
	private NutritionFacts(Builder builder){
		this.servingSize = builder.servingSize;
		this.servings = builder.servings;
		this.calories = builder.calories;
		this.fat = builder.fat;
		this.sodium = builder.sodium;
		this.carbohydrate = builder.carbohydrate;
	}
	public static class Builder{
		private int servingSize;	//(mL)				required
		private int servings;		//(per container)	required
		private int calories=0;		//					optional
		private int fat=0;			//(g)				optional
		private int sodium=0;       //(mg)				optional
		private int carbohydrate=0;	//(g)				optional
		public Builder(int servingSize,int servings){
			this.servingSize = servingSize;
			this.servings = servings;
		}
		public Builder setServingSize(int servingSize) {
			this.servingSize = servingSize;
			return this;
		}
		public Builder setServings(int servings) {
			this.servings = servings;
			return this;
		}
		public Builder setCalories(int calories) {
			this.calories = calories;
			return this;
		}
		public Builder setFat(int fat) {
			this.fat = fat;
			return this;
		}
		public Builder setSodium(int sodium) {
			this.sodium = sodium;
			return this;
		}
		public Builder setCarbohydrate(int carbohydrate) {
			this.carbohydrate = carbohydrate;
			return this;
		}
		public NutritionFacts build(){return new NutritionFacts(this);}
	}
}
