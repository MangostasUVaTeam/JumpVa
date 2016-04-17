(function (){

    var app = angular.module('toolbar', [ ]);


    app.controller("SearchController",['$scope','logedUser', function($scope,logedUser){
        this.search = function(text){
            console.log(logedUser);
            console.log(text);
        };
    }]);


    app.controller("NewDeliveryController",['$scope','$uibModal' ,'logedUser', function($scope,$uibModal, logedUser){
        this.logedUser = logedUser;

        this.openModal = function(){
            console.log("hola");
            $uibModal.open({
                templateUrl: 'includes/search-delivery.html',
            });
        };
    }]);


    app.controller("UserDataController", ['$scope','$location', 'logedUser', function($scope,$location, logedUser){

        this.username = function(){
            return logedUser.username;
        }

        this.logout = function(){
            logedUser = {};
            console.log("Logout");
            $location.path('/login');
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
