(function (){

    var app = angular.module('mainContent', [ ]);

    app.controller("DeliveryController", [ '$scope',function($scope){
        deliveryCtrl = this;

        deliveryCtrl.delivery = {
            dropdown: false
        };

        deliveryCtrl.toggleDropdown = function(){
            if (deliveryCtrl.delivery.dropdown){
                deliveryCtrl.delivery.dropdown = false;
            } else {
                deliveryCtrl.delivery.dropdown = true;
            }
        };
    }]);

})();
