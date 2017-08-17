package com.ctchan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/8/9.
 */
public class PublicClass {
	private String username;
	private String password;


	public class PrivateClass {
		private String age;
		private String address;

		public String getAge() {
			return age;
		}

		public PrivateClass setAge(String age) {
			this.age = age;
			return this;
		}

		public String getAddress() {
			return address;
		}

		public PrivateClass setAddress(String address) {
			this.address = address;
			return this;
		}

		@Override
		public String toString() {
			final StringBuffer sb = new StringBuffer("PrivateClass{");
			sb.append("age='").append(age).append('\'');
			sb.append(", address='").append(address).append('\'');
			sb.append('}');
			return sb.toString();
		}
	}

	public String getUsername() {
		return username;
	}

	public PublicClass setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public PublicClass setPassword(String password) {
		this.password = password;
		return this;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("PublicClass{");
		sb.append("username='").append(username).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append('}');
		return sb.toString();
	}

	public static void main(String[] args) {
		PublicClass publicClass = new PublicClass();
		publicClass.setPassword("passwordValue");
		publicClass.setUsername("usernameValue");
		System.out.println(publicClass);
		PrivateClass privateClass = publicClass.new PrivateClass();
		privateClass.setAddress("addressValue");
		privateClass.setAge("age");
		System.out.println(privateClass);

	}

}
