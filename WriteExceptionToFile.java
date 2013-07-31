class WriteExceptionToFile{

	protected void printError(Exception e) {
		PrintWriter pw = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
			String date = sdf.format(new Date());
			String filePath = context.getRealPath("/")+"\\logs\\"+date+"-log.txt";
			System.out.println(filePath);
			pw = new PrintWriter(
					new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(filePath,true),"utf-8")),true);
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String time = sdf1.format(new Date());
			pw.append("=================="+time+"==============================\r\n");
			e.printStackTrace(pw);
		} catch (Exception e1) {
			e.printStackTrace();
		}
	}

}
