(function (){

    var app = angular.module('login', [ 'jumpva']);


    app.controller("LoginController",['$scope','logedUser', function($scope,logedUser){
        this.login = function(){
            console.log("Login");
        };
    }]);
})();
