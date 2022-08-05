package br.edu.ifbaiano.homines.api.exceptionhandler;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Problem {

	private Integer status;
	private String title;
	private String detail;
	private List<Field> fields;

	private List<Problem.Object> objects;
	
	public static class Field{
		private String name;
		private String userMessage;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUserMessage() {
			return userMessage;
		}
		public void setUserMessage(String userMessage) {
			this.userMessage = userMessage;
		}
		
		public static FieldBuilder builder() {
            return new FieldBuilder();
        }
		
		public static final class FieldBuilder {
			private String name;
			private String userMessage;
			
			private FieldBuilder() {
				
			}
			
			public static FieldBuilder anField() {
				return new FieldBuilder();
			}
			
			public FieldBuilder name(String name) {
				this.name = name;
				return this;
			}
			
			public FieldBuilder userMessage(String userMessage) {
				this.userMessage = userMessage;
				return this;
			}
			
			public Field build() {
				Field field = new Field();
				field.setName(name);
				field.setUserMessage(userMessage);
				return field;
			}
			
		}
	}
	
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	
	public List<Problem.Object> getObjects() {
		return objects;
	}
	public void setObjects(List<Problem.Object> objects) {
		this.objects = objects;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	 public static ProblemBuilder builder() {
	        return new ProblemBuilder();
	    }
	 
	 public static final class Object {
	        private String name;
	        private String userMessage;

	        public String getName() {
	            return name;
	        }

	        public void setName(String name) {
	            this.name = name;
	        }

	        public String getUserMessage() {
	            return userMessage;
	        }

	        public void setUserMessage(String userMessage) {
	            this.userMessage = userMessage;
	        }

	        public static ObjectBuilder builder() {
	            return new ObjectBuilder();
	        }

	        public static final class ObjectBuilder {
	            private String name;
	            private String userMessage;

	            private ObjectBuilder() {
	            }

	            public static ObjectBuilder anObject() {
	                return new ObjectBuilder();
	            }

	            public ObjectBuilder name(String name) {
	                this.name = name;
	                return this;
	            }

	            public ObjectBuilder userMessage(String userMessage) {
	                this.userMessage = userMessage;
	                return this;
	            }

	            public Object build() {
	                Object object = new Object();
	                object.setName(name);
	                object.setUserMessage(userMessage);
	                return object;
	            }
	        }
	    }

	    public static final class ProblemBuilder {
	        private Integer status;
	        private String title;
	        private String detail;
	        private List<Field> fields;
	        private List<Problem.Object> objects;

	        private ProblemBuilder() {
	        }

	        public ProblemBuilder status(Integer status) {
	            this.status = status;
	            return this;
	        }

	        public ProblemBuilder title(String title) {
	            this.title = title;
	            return this;
	        }

	        public ProblemBuilder detail(String detail) {
	            this.detail = detail;
	            return this;
	        }

	        public ProblemBuilder fields(List<Problem.Field> fields) {
	        	this.fields = fields;
	        	return this;
	        }

	        public ProblemBuilder objects(List<Problem.Object> objects) {
	            this.objects = objects;
	            return this;
	        }

	        public Problem build() {
	            Problem problem = new Problem();
	            problem.setStatus(status);
	            problem.setTitle(title);
	            problem.setDetail(detail);
	            problem.setFields(fields);
	            problem.setObjects(objects);
	            return problem;
	        }
	    }
	
}
