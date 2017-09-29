package com.chan.Effective.Buidler;

import com.chan.Effective.Builder.Demo.NutritionFacts;
import com.chan.Effective.EffectiveJavaContents;
import com.chan.test.DemoExplain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Osborn on 2017/7/18.
 */
public enum Builder implements DemoExplain {
	U1(1,"书本P9-P11对应实例", NutritionFacts.class);

	private final String title;
	private final Integer id;
	private Class<?> clazz = null;

	Builder(Integer id, String title, Class<?> clazz) {
		this.title = title;
		this.id = id;
		if (clazz == null)
			return;
		this.clazz = clazz;

	}

	@Override
	public String explain() {
		return this.name() + "{" +
			id + ". '" + title + '\'' +
			" : " + (clazz == null ? clazz : clazz.getName()) +
			'}';
	}

	@Override
	public Boolean needToString() {
		return false;
	}

	@Override
	public String toString() {
		return explain();
	}

	public static void main(String[] args) {
		List<EffectiveJavaContents> list = new ArrayList<EffectiveJavaContents>() {
			public String toString() {
				Iterator<EffectiveJavaContents> it = iterator();
				if (!it.hasNext())
					return "[]";

				StringBuilder sb = new StringBuilder();
				for (; ; ) {
					EffectiveJavaContents e = it.next();
					sb.append(e.equals(this) ? "(this Collection)" : e);
					if (!it.hasNext())
						return sb.append('.').toString();
					sb.append(',').append('\n');
				}
			}
		};
		Collections.addAll(list, EffectiveJavaContents.values());
		System.out.println(list);
	}
}
