(function (){

    var app = angular.module('jumpVa', [ ]);

    app.value('logedUser', {
        username: "Paco",
        carrier: true
    });


    app.controller("SearchController",['$scope','logedUser', function($scope,logedUser){
        this.search = function(text){
            console.log(logedUser);
            console.log(text);
        };
    }]);


    app.controller("NewDeliveryController",['$scope', 'logedUser', function($scope, logedUser){
        this.logedUser = logedUser;
    }]);



    app.controller("ToolController", ['$scope', 'logedUser', function($scope, logedUser){
        this.settings = logedUser;
    }]);

    app.controller("UserDataController", ['$scope', 'logedUser', function($scope, logedUser){

        this.username = function(){
            return logedUser.username;
        }

        this.carrier = function(){
            if (logedUser.carrier){
                return "Transportista";
            } else {
                return "Cliente";
            }
        }
    }]);
})();
