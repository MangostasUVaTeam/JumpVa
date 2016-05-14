(function (){

    var app = angular.module('pending-to-assing-delivery', []);

    app.controller('PendingToAssingController', function (user) {
        var self = this;

        self.getPanelClass = function(bid){
            switch(bid.carrier){
                case user.email:
                    return 'panel-primary';
                default:
                    return 'panel-default';
            }
        }


    });

})();
