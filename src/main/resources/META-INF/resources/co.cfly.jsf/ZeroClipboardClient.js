var zclip;

function startZclip(id, zclip_path, copyText, copiedText) {
        if (zclip == null) {
                ZeroClipboard.setDefaults({
                        moviePath : zclip_path
                });
                zclip = new ZeroClipboard();
                zclip.on('complete', function(zclip, args) {
                        $('.clipboard-copy-div').text(copyText);
                        $(this).text(copiedText);
                });
                zclip.on('wrongflash', function(zclip, args) {
                        $('.clipboard-copy-div').hide();
                });
                zclip.on('noflash', function(zclip, args) {
                        $('.clipboard-copy-div').hide();
                });
                window.onresize = zclipReposition(zclip);
        }
        var zclip_target_id = '#' + id.replace(/:/g, "\\:");
        zclip.glue($(zclip_target_id));
}

function zclipReposition(zclip) {
        zclip.reposition();
}