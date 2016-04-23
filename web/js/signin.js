(function (){

    var app = angular.module('signin', ['jumpva']);


    app.controller("SigninController", function($scope,$location,logedUser){

        var signinCtrl = this;

        this.cancel = function(){
            $location.path('/home');
        };

        this.createAccount = function(){
            $location.path('/main');
        };

    });
})();
