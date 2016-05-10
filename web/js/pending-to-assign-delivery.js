(function (){

    var app = angular.module('pending-to-assing-delivery', []);

    app.controller('PendingToAssingController', function (user) {
        var self = this;

        self.getOffer = function(shipment){
            return shipment.bidList.find(function(bid){
                return find.carrier === user.email;
            });
        }


        console.log("HOLA");
    });

})();
