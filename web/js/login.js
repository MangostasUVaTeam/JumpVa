(function (){

    var app = angular.module('login', [ 'jumpva']);


    app.controller("LoginController",['$scope','$location','logedUser', function($scope,$location,logedUser){
        this.login = function(){
            console.log("Login");
            $location.path('/main');
        };
    }]);
})();
