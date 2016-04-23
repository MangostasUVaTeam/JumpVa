(function (){

    var app = angular.module('login', ['jumpva']);


    app.controller("LoginController", function($scope,$location,logedUser){

        var loginCtrl = this;


        this.login = function(){
            console.log("Login");
            $location.path('/main');
        };

        this.cancel = function(){
            $location.path('/home');
        };

    });
})();
