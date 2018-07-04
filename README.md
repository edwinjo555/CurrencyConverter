# CurrencyConverter

Prerequisites
Add Dependencies to gradle

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

	dependencies {
	        implementation 'com.github.edwinjo555:CurrencyConverter:-SNAPSHOT'
	}


Method Call

//To get conversion rate: 

double output = EasyCurrency.convertCurrency("inr","USD");


//To get conversion rate of specific value

double output=EasyCurrency.getCurrencyExchange("eur","inr",5);

Note: Only currency code is available. No country code or country name are allowed.
