(function (){

    var app = angular.module('main', ['jumpva']);

    app.controller("MainController", function($scope, logedUser){
    });


    app.directive('jumpvaToolbar', function(){
        return {
            restrict: 'E',
            templateUrl: 'includes/toolbar.html'
        };
    });


    app.directive('jumpvaMainContent', function(){
        return {
            restrict: 'E',
            templateUrl: 'includes/main-content.html'
        };
    });

})();
