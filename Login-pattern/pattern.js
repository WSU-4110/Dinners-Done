var foodOption = function () {
    this.createuser = function (choice) {
        var user;

        if (choice === "Creamy Garlic Shrimp") {
            user = new Food1();
        } else if (choice === "Pesto Penne Pasta") {
            choice = new Food2();
        } else if (choice === "Glazed Honey Balsamic Pork Chops") {
            user = new Food3();
        } else if (choice === "Creamy Tuscan Chicken") {
            user = new Food4();
        }

        user.type = type;

        user.say = function () {
            console.log(this.choice + ": Food option " + this.food + " ");
        }

        return user;
    }
}

var Food1 = function () {
    this.food = "Creamy Garlic Shrimp";
};

var Food2 = function () {
    this.food = "Pesto Penne Pasta";
};

var Food3 = function () {
    this.food = "Glazed Honey Balsamic Pork Chops";
};

var Food4 = function () {
    this.food = "Creamy Tuscan Chicken";
};

function run() {

    var users = [];
    var factory = new foodOption();

    users.push(factory.createuser("Creamy Garlic Shrimp"));
    users.push(factory.createuser("Pesto Penne Pasta"));
    users.push(factory.createuser("Glazed Honey Balsamic Pork Chops"));
    users.push(factory.createuser("Creamy Tuscan Chicken"));

    for (var i = 0, len = users.length; i < len; i++) {
        users[i].say();
    }
}