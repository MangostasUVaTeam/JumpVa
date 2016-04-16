(function (){

    var app = angular.module('toolbar', [ ]);


    app.controller("SearchController",['$scope','logedUser', function($scope,logedUser){
        this.search = function(text){
            console.log(logedUser);
            console.log(text);
        };
    }]);

    app.controller("NewDeliveryController",['$scope', 'logedUser', function($scope, logedUser){
        this.logedUser = logedUser;
    }]);

    app.controller("UserDataController", ['$scope', 'logedUser', function($scope, logedUser){

        this.username = function(){
            return logedUser.username;
        }

        this.logout = function(){
            logedUser = {};
            console.log("Logout");
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
