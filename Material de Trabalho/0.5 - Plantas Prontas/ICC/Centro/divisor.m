clear all
close all

nome = 'ICC_CENTRO_SS';
bSize = 256;


imgNome = strcat(nome, '.png');
[imagem, map, file] = imread(imgNome);

[h, l] = size(file)
[h, l] = size(imagem(:, :, 1))


i = ceil(h/bSize);
j = ceil(l/bSize);

h = i*bSize;
l = j*bSize;

imagem = imresize(imagem, [h, l]);
file = imresize(file, [h, l]);
nome2 = strcat(nome, '0', '.png');
imwrite(imagem, nome2 , 'png');

bloco = uint8(zeros(bSize, bSize, 3));
%bfile = uint8(zeros(bSize, bSize));
for p = 1:i
    for k = 1: j
        ii = (p-1)*bSize + 1;
        ij = (p-1)*bSize+bSize;
        fi = (k-1)*bSize+1;
        fj = (k-1)*bSize+bSize;
        bloco(:, :, :) = imagem(ii:ij, fi:fj, :);
        %bfile(:, :) = imagem(ii:ij, fi:fj);
        blockname = strcat(nome,'-', int2str(p),'-', int2str(k), '.png');
        %[imagem2, map, file] = imread(nome2, 'pixelregion' ,{[ii ij], [fi fj]});
        imwrite(bloco, blockname, 'png');
    end
end






