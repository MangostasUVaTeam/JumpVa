(function (){

    var app = angular.module('jumpva', ['toolbar','mainContent']);

    app.value('logedUser', {
        username: "Paco",
        carrier: true
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
    app.controller("ToolController", ['$scope', 'logedUser', function($scope, logedUser){
        this.settings = logedUser;
    }]);


})();
