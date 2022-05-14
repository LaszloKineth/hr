package hu.webuni.hr.kinela.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="hr")
@Component
public class EmployeeConfigurationProperties {
		
		private static Years years = new Years();
		private static Percent percent = new Percent();
	
		public static class Years {
			private int max;
			private int mid;
			private int min;
			
			public int getMax() {
				return max;
			}
			public void setMax(int max) {
				this.max = max;
			}
			public int getMid() {
				return mid;
			}
			public void setMid(int mid) {
				this.mid = mid;
			}
			public int getMin() {
				return min;
			}
			public void setMin(int min) {
				this.min = min;
			}
			
		}
		
		public static class Percent {
			private int max;
			private int mid1;
			private int mid2;
			private int min;
			private int dfault;

			public int getMax() {
				return max;
			}
			public void setMax(int max) {
				this.max = max;
			}
			public int getMid1() {
				return mid1;
			}
			public void setMid1(int mid1) {
				this.mid1 = mid1;
			}
			public int getMid2() {
				return mid2;
			}
			public void setMid2(int mid2) {
				this.mid2 = mid2;
			}
			public int getMin() {
				return min;
			}
			public void setMin(int min) {
				this.min = min;
			}
			public int getDfault() {
				return dfault;
			}
			public void setDfault(int dfault) {
				this.dfault = dfault;
			}
			
		}

		public Years getYears() {
			return years;
		}

		public void setYears(Years years) {
			this.years = years;
		}

		public Percent getPercent() {
			return percent;
		}

		public void setPercent(Percent percent) {
			this.percent = percent;
		}
}
