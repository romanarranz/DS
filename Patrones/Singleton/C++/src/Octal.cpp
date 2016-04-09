#include <Octal.h>

Octal::Octal(){}

void Octal::setValue(int in) {
  	char buf[10];
  	sprintf(buf, "%o", in);
  	sscanf(buf, "%d", &value);
}

Number * Number::getInstance() {
	
	if (!INSTANCE) {
	    // 3. Do "lazy initialization" in the accessor function
	    if (type == "octal")
	      	INSTANCE = new Octal();
	    else 
    		INSTANCE = new Number();
    }

  	return INSTANCE;
}