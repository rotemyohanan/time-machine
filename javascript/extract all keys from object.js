

var item2 = {
    "a": "a",
    "b": "b",
    "c": {
        "c1" : "c1",
        "c2" : "c2",
        "c3" : {
            "c3a" : "c3a",
            "c3b" : "c3b",
            "c3c" : [
                { "c3ca" : "c3ca" },
                { "c3cb" : "c3cb" },
                "zzz",
                { 3: "444"}
            ]
        }
    }

};

var createFlatObject = function(object){
    var keys = Object.keys(object);
    keys.forEach(function(key){
        if(isSimpleValue(object[key])){
            newObj[key] = object[key];
        } else {
            keepDrill(key, object[key])
        }
    });
    return newObj
};

var keepDrill = function (key, value) {
     if( Object.prototype.toString.call( value ) === "[object Array]" ) {
        value.forEach(function(item){
            if(isSimpleValue(item)) {
                newObj[key] = item;
            } else if(Object.prototype.toString.call( item ) === "[object Object]"){
                var keys = Object.keys(item);
                keys.forEach(function(nested_key){
                    keepDrill(key + "." + nested_key, item[nested_key]);
                });
            }
        });
    } else if (Object.prototype.toString.call( value ) === "[object Object]") {
        var keys = Object.keys(value);
        keys.forEach(function (new_key) {
            if(isSimpleValue(value[new_key])) {
                newObj[key + "." + new_key] = value[new_key];
            } else {
                keepDrill(key + "." + new_key, value[new_key]);
            }
        })
    } else {
         newObj[key] = value;
     }
};

var isSimpleValue = function(value) {
    switch (typeof(value)) {
        case "string":
            return true;
        case "number":
            return true;
        case "boolean":
            return true;
        default:
            return false;
    }
};

var newObj = {};

var run = function (json) {
    var result = createFlatObject(json);
//     console.log(result);
    print(result);
};

run(item2);
