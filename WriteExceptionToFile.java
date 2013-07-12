class WriteExceptionToFile{

	public void response(String className, String methodName, String json){
		System.out.println(methodName + ":"+json);
		String responseJson = "";
		try {
			Class clz = Class.forName(className);
			Method m1 = clz.getDeclaredMethod(methodName, String.class);
			responseJson = (String) m1.invoke(clz.newInstance(), json);
		} catch (Exception e) {
			e.printStackTrace();
			PrintWriter pw;
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = sdf.format(new Date());
				String filePath = context.getRealPath("/")+"logs/"+date+"-log.txt";
				pw = new PrintWriter(
						new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(filePath,true),"utf-8")),true);
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String time = sdf1.format(new Date());
				pw.append("=================="+time+"==============================\n");
				e.printStackTrace(pw);
			} catch (Exception e1) {
				System.out.println(e1);
			} 
			
			System.out.println(JsonUtils.FAIL);
			JsonUtils.writeJSON(JsonUtils.FAIL);
		}
		System.out.println("response:"+responseJson);
		JsonUtils.writeJSON(responseJson);
	}

}