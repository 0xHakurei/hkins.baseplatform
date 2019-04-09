package hkins.baseplatform.response;

public class Response {
	
	private static final String OK = "ok";
	private static final String ERROR = "error";
	
	private Meta meta;
	private Object data;
	private String time;
	
	public Meta getMeta() {
		return meta;
	}

	public Object getData() {
		return data;
	}

	public String getTime() {
		return time;
	}

	public Response success() {
		this.meta = new Meta(true, OK);
		return this;
	}
	
	public Response success(Object data) {
		this.meta = new Meta(true, OK);
		this.data = data;
		return this;
	}
	
	public Response success(Object data, String time) {
		this.meta = new Meta(true, OK);
		this.data = data;
		this.time = time;
		return this;
	}
	
	public Response failure() {
		this.meta = new Meta(false, ERROR);
		return this;
	}
	
	public Response failure(String message) {
		this.meta = new Meta(false, message);
		return this;
	}
	
	public class Meta {
		
		private boolean success;
		private String message;
		
		public Meta(boolean success) {
			this.success = success;
		}
		
		public Meta(boolean success, String message) {
			this.success = success;
			this.message = message;
		}
		
		public boolean isSuccess() {
			return this.success;
		}
		
		public String getMessage() {
			return this.message;
		}
	}
}

